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
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'accepts'");
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
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'toString'");
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
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'addTransition'");
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
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'swap'");
	}
}
