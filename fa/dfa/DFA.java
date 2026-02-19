package fa.dfa;

import fa.State;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Represents a Deterministic Finite Automaton (DFA).
 * Implements the DFAInterface to provide a complete DFA implementation.
 */
public class DFA implements DFAInterface {
	
	private Set<DFAState> states;
	private Set<Character> sigma;
	private Map<DFAState, Map<Character, DFAState>> delta;
	private DFAState startState;
	private Set<DFAState> finalStates;
	
	/**
	 * Constructor for DFA
	 */
	public DFA() {
		states = new LinkedHashSet<>();
		sigma = new LinkedHashSet<>();
		delta = new LinkedHashMap<>();
		startState = null;
		finalStates = new LinkedHashSet<>();
	}

	/**
	 * Adds a state to the DFA instance
	 * @param name is the label of the state 
	 * @return true if a new state created successfully and false if there is already state with such name
	 */
	@Override
	public boolean addState(String name) {
		// TODO Auto-generated method stub
		if (name == null) return false;
		for (DFAState s :states){
			if(name.equals(s.getName())) return false;

		}
		DFAState ns = new DFAState(name);
		boolean isAdded = states.add(ns);
		if (isAdded) delta.put(ns,new LinkedHashMap<>());
		return isAdded;
		
	}

	/**
	 * Marks an existing state as an accepting state
	 * @param name is the label of the state
	 * @return true if successful and false if no state with such name exists
	 */
	@Override
	public boolean setFinal(String name) {
		State s = getState(name);
		if (s== null) return false;
		return finalStates.add((DFAState) s); 
	}

	/**
	 * Adds the initial state to the DFA instance
	 * @param name is the label of the start state
	 * @return true if successful and false if no state with such name exists
	 */
	@Override
	public boolean setStart(String name) {
		State s = getState(name);
		if (s== null) return false;
		startState= (DFAState) s; 
		return true;
	}

	/**
	 * Adds a symbol to Sigma
	 * @param symbol to add to the alphabet set
	 */
	@Override
	public void addSigma(char symbol) {
		sigma.add(symbol);
	}

	/**
	 * Simulates a DFA on input s to determine
	 * whether the DFA accepts s.
	 * @param s - the input string
	 * @return true if s in the language of the DFA and false otherwise
	 */
	@Override
	public boolean accepts(String s) {
		if (startState == null || s == null) return false;
		DFAState currentState = startState;
		
		//Loops through each character in input sting
		for (char c : s.toCharArray()) {
			if (!sigma.contains(c)) return false; //rejects char if not in current alphabet
			Map<Character, DFAState> transitions = delta.get(currentState);  //gets the transition map for current state
			if (transitions == null) return false; //reject if somehow no transition row exists
			DFAState nextState = transitions.get(c); //if no transitions defined for current symbol rejects char
			if (nextState == null) return false;
			currentState = nextState;
		}
		return finalStates.contains(currentState); //after processing all characters, accepts ended on a final state
	}

	/**
	 * Getter for Sigma
	 * @return the alphabet of FA
	 */
	@Override
	public Set<Character> getSigma() {
		return new LinkedHashSet<>(sigma); //returns a copy of sigma 
	}

	/**
	 * Returns state with the given name, or null if none exists
	 * @param name of a state
	 * @return state object or null
	 */
	@Override
	public State getState(String name) {
		if (name == null) return null; //if name provided empty, return null
		for (DFAState s: states){
			if (name.equals(s.getName())) return s; // return found state

		}
		return null; // if no matching state found
	}

	/**
	 * Determines if a state with a given name is final
	 * @param name the name of the state
	 * @return true if a state with that name exists and it is final
	 */
	@Override
	public boolean isFinal(String name) {
		for(DFAState s:finalStates){
			if(name.equals(s.getName())) return true;
			
		}
		return false;
	}

	/**
	 * Determines if a state with name is the start state
	 * @param name the name of the state
	 * @return true if a state with that name exists and it is the start state
	 */
	@Override
	public boolean isStart(String name) {
		if (startState == null) return false;
		return startState.equals(getState(name));
	}

	/**
	 * Construct the textual representation of the DFA, for example
	 * A simple two state DFA
	 * Q = { a b }
	 * Sigma = { 0 1 }
	 * delta =
	 *		0	1	
	 *	a	a	b	
	 *	b	a	b	
	 * q0 = a
	 * F = { b }
	 * 
	 * The order of the states and the alphabet is the order
	 * in which they were instantiated in the DFA.
	 * @return String representation of the DFA
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		// Q = { states }
		sb.append("Q = { ");
		for (DFAState s : states) {
			sb.append(s.getName()).append(" ");
		}
		sb.append("}");
		sb.append(System.lineSeparator());
		
		// Sigma = { symbols }
		sb.append("Sigma = { ");
		for (char c : sigma) {
			sb.append(c).append(" ");
		}
		sb.append("}");
		sb.append(System.lineSeparator());
		
		// delta table
		sb.append("delta =");
		sb.append(System.lineSeparator());
		sb.append("\t");
		for (char c : sigma) {
			sb.append(c).append("\t");
		}
		sb.append(System.lineSeparator());
		
		for (DFAState s : states) {
			sb.append(s.getName()).append("\t");
			for (char c : sigma) {
				DFAState next = delta.get(s).get(c);
				if (next != null) {
					sb.append(next.getName());
				}
				sb.append("\t");
			}
			sb.append(System.lineSeparator());
		}
		
		// q0
		sb.append("q0 = ");
		if (startState != null) {
			sb.append(startState.getName());
		}
		sb.append(System.lineSeparator());
		
		// F
		sb.append("F = { ");
		for (DFAState s : finalStates) {
			sb.append(s.getName()).append(" ");
		}
		sb.append("}");
		
		return sb.toString();
	}

	/**
	 * Adds the transition to the DFA's delta data structure
	 * @param fromState is the label of the state where the transition starts
	 * @param toState is the label of the state where the transition ends
	 * @param onSymb is the symbol from the DFA's alphabet.
	 * @return true if successful and false if one of the states don't exist or the symbol in not in the alphabet
	 */
	@Override
	public boolean addTransition(String fromState, String toState, char onSymb) {
		// Get the actual state objects
		State fromStateObj = getState(fromState);
		State toStateObj = getState(toState);
		
		// Check if both states exist
		if (fromStateObj == null || toStateObj == null) return false;
		
		// Check if symbol is in sigma
		if (!sigma.contains(onSymb)) return false;
		
		// Cast to DFAState
		DFAState from = (DFAState) fromStateObj;
		DFAState to = (DFAState) toStateObj;
		
		// Get transition map for fromState and add the transition
		Map<Character, DFAState> transitions = delta.get(from);
		if (transitions == null) return false;  // ideally shouldn't happen if addState initialized properly
		
		transitions.put(onSymb, to);
		return true;
	}

	/**
	 * Creates a deep copy of this DFA
	 * which transitions labels are
	 * swapped between symbols symb1
	 * and symb2.
	 * @return a copy of this DFA
	 */
	@Override
	public DFA swap(char symb1, char symb2) {
		DFA copy = new DFA();
		
		// Copy all states
		for (DFAState s : states) {
			copy.addState(s.getName());
		}
		
		// Copy all symbols
		for (char c : sigma) {
			copy.addSigma(c);
		}
		
		// Copy transitions with swapped symbols
		for (DFAState from : states) {
			Map<Character, DFAState> transitions = delta.get(from);
			if (transitions != null) {
				for (char c : transitions.keySet()) {
					DFAState to = transitions.get(c);
					char actualSymbol = c;
					
					// Swap if this is one of the symbols
					if (c == symb1) {
						actualSymbol = symb2;
					} else if (c == symb2) {
						actualSymbol = symb1;
					}
					copy.addTransition(from.getName(), to.getName(), actualSymbol);
				}
			}
		}
		// Copy start state
		if (startState != null) {
			copy.setStart(startState.getName());
		}
		
		// Copy final states
		for (DFAState s : finalStates) {
			copy.setFinal(s.getName());
		}
		
		return copy;
	}
}
