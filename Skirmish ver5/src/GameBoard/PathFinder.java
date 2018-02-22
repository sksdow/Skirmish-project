package GameBoard;

import java.util.*;

public class PathFinder {
	
	private MapData m;
	private ArrayList<Node> visited;
	private PriorityQueue<Node> needsVisit;
	private PriorityQueue<Node> solutions;
	private Coordinate goal;
	private int moveCost;
	private int energy;
	private int traveled;
	
	public PathFinder(MapData map) {
		m = map;
		initialize();
	}
	
	private void initialize() {
		visited = new ArrayList<Node>();
		needsVisit = new PriorityQueue<Node>(10, new NodeComparator());
		solutions = new PriorityQueue<Node>(10, new NodeComparator());
	}
	
	public ArrayList<Coordinate> findPath(Coordinate start, Coordinate goal, int moveCost, int energy) {
		initialize();
		
		this.goal = goal;
		this.moveCost = moveCost;
		this.energy = energy;
		
		if (!m.isVacant(goal)){
			//System.out.println("invalid destination");
			return null;}
		else if (estimatedCost(start)*moveCost > energy)
			return null;
		
		Node s = new Node(start, null);
		s.estimatedCost = estimatedCost(s);
		needsVisit.add(s);
		
		while (needsVisit.size() != 0 && solutions.size() == 0) {
			searchIteration();
		}
		
		Node n = solutions.poll();
		
		if (n == null) return null;
		
		return getPath(n);
	}
	
	private void searchIteration() {
		
		Node n = needsVisit.poll();
		n.estimatedCost = estimatedCost(n);
		
		visited.add(n);
		
		if (n.estimatedCost == 0) {
			solutions.add(n);
			return; // Solution found.
		} else if ((n.cost + 1) * moveCost > energy) {
			return; // Moved too far.
		}
		
		// Possible Moves
		ArrayList<Coordinate> maybeMove = new ArrayList<Coordinate>();
		maybeMove.add(n.data.translate(0, 1));
		maybeMove.add(n.data.translate(0, -1));
		maybeMove.add(n.data.translate(1, 0));
		maybeMove.add(n.data.translate(-1, 0));
		
		// Check Possible Moves
		for (int i = 0; i < maybeMove.size(); i++) {
			Coordinate c = maybeMove.get(i);
				
			if (!(c.getX() >= 0 && c.getX() < m.getWidth() && c.getY() >= 0 && c.getY() < m.getHeight())||!m.isVacant(c)) { 
				continue;
			} else if (needsVisit.contains(c)) {
				//System.out.println("DUPLICATE");
				continue;
			} else if (isValid(c)) {
				Node move = new Node(c, n);
				move.estimatedCost = estimatedCost(move);
				needsVisit.add(move);
			}
		}
	}
	
	private int estimatedCost(Coordinate c) {
		if (goal != null) {
			return Math.abs(c.getX() - goal.getX()) + Math.abs(c.getY() - goal.getY());
		}
		return Integer.MAX_VALUE;
	}
	
	// Assumes n != null
	private int estimatedCost(Node n) {
		return estimatedCost(n.data);
	}
	
	private boolean isValid(Coordinate c) {
		Iterator<Node> i = needsVisit.iterator();
		while (i.hasNext()) {
			if (i.next().equals(c))
				return false;
		}
		
		i = visited.iterator();
		while (i.hasNext()) {
			if (i.next().equals(c))
				return false;
		}
		return true;
	}
	
	private ArrayList<Coordinate> getPath(Node n) {
		ArrayList<Coordinate> p = new ArrayList<Coordinate>();
		
		do {
			p.add(0, n.data);
			n = n.previous;
		} while (n != null);
		traveled=p.size()-1;
		return p;
	}
	
	public int getDistanceTraveled(){
		return traveled;
	}
	
}

class Node {
	
	public int cost;
	public int estimatedCost;
	public Coordinate data;
	
	public Node next;
	public Node previous;
	
	public Node(Coordinate data, Node previous) {
		this.data = data;
		if (previous == null) {
			this.previous = null;
			cost = 0;
		} else {
			this.previous = previous;
			this.previous.next = this;
			cost = previous.cost + 1;
		}
		this.next = null;
	}
	
	public boolean equals(Object o) {
		if (o instanceof Node) {
			Node n = (Node)o;
			if (n.data.equals(data))
				return true;
		} else if (o instanceof Coordinate) {
			if (data.equals((Coordinate)o))
				return true;
		}
		return false;
	}
	
	
}

class NodeComparator implements Comparator<Node> {
	
	public int compare(Node x, Node y) {
		return (x.estimatedCost + x.cost) - (y.estimatedCost + y.cost);
	}
	
}
