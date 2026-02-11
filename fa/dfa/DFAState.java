package fa.dfa;

import fa.State;

/**
 * Represents a state in a Deterministic Finite Automaton (DFA).
 * Extends the abstract State class to provide DFA-specific functionality.
 * @author Calvin Arnold
 */
public class DFAState extends State {
	
	/**
	 * Constructor for DFAState
	 * @param name the label/name of the state
	 */
	public DFAState(String name) {
		super(name);
	}
}
