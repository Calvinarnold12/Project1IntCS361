# ****************
# Project 1
# Class CS361
# Date 02/18/2026
# Calvin Arnold, Audrey Fitchett
# ****************

## OVERVIEW:

This program simulates a deterministic finite automaton. It stores the alphabet, states, 
start state, final states, and transition table, and can verify whether or not a 
string would be accepted by the DFA. 

## INCLUDED FILES:

* DFA.java - source file
* DFAInterface.java - source file
* DFAState.java - source file
* FAInterface.java - source file
* State.java - source file 
* DFATest.java - source file
* README - this file

## COMPILING AND RUNNING:

From the directory containing all source files, compile the
driver class (and all dependencies) with the command:
$ javac DFATest.java
Run the compiled class file with the command:
$ java DFATest

There is no user input for this program. Once the program is finished running, output will show up in the console. 

## PROGRAM DESIGN AND IMPORTANT CONCEPTS:

### Overall Design

This program implements a Detinistic Finite Automaton (DFA) using object-oriented design principles. The implementation separates:

- Abstract behavior (via FAInterface)  
- Shared state structure (via abstract State)  
- DFA-specific logic (via DFA and DFAState)  

This separation ensures modularity, extensibility, and clarity of responsibility.

The DFA is internally represented using:

- A Set<DFAState> for all states  
- A Set<Character> for the alphabet (Sigma)  
- A nested Map<DFAState, Map<Character, DFAState>> to represent transitions (delta function)  
- A single DFAState reference for the start state  
- A Set<DFAState> for final (accepting) states  

The use of LinkedHashSet and LinkedHashMap preserves insertion order, which ensures the toString() method outputs states and alphabet symbols in the order they were added, as required by the project specification.

---

### Class Responsibilities

#### State (Abstract Class)

- Stores a unique state name.  
- Provides getName() and toString() functionality.  
- Ensures all concrete states must initialize with a name.  

This abstraction allows flexibility if other automata types (e.g., NFA) are implemented later.

---

#### DFAState

- Extends State.  
- Does not add new behavior but provides type distinction for DFA-specific usage.  
- Allows safe casting when interacting with DFA transition structures.  

---

#### FAInterface

Defines required behavior for any finite automaton:

- Adding states  
- Marking start/final states  
- Adding alphabet symbols  
- Running the automaton on input (accepts)  
- Querying state properties  

This interface ensures the DFA adheres to formal automata structure.



## TESTING:

We tested the program using the tests provided in DFATest.java and an
additional test created by us to check what happens if an alphabet
has 3 symbols and if the start state is also the final state. Our
program seems fairly idiot-proof, as there are ways to hand if
someone tries to add a state that's already exists in the set of 
states, or create a transition that using a symbol outside of the 
alphabet or with a state that doesn't exist.   


---

## DISCUSSION:

-Calvin: The most challenging part of this assignment was visualizing the interaction between the HashMap and HashSet data structures, particularly when implementing the transition function. The nested delta map (mapping a state to another map of symbol-to-state transitions) was difficult to conceptualize mentally. I frequently found myself losing track of which keys mapped to which values during debugging.

I also reviewed these W3schools articles on the java hashmap/set packages.

https://www.w3schools.com/java/java_hashset.asp  
https://www.w3schools.com/Java/java_hashmap.asp  

What helped significantly was writing out a visual representation of the structure on paper.

Audrey: Some things I struggled with were understanding what was going on in the tests, and conceptualizing how the dfa swap
method was supposed to work. Drawing out each DFA in the given tests really helped me understand the things each test was
looking at, and what things could be tested that were missing. Drawing out the dfa swapped helped a bit too, but what 
really helped understand the dfa swap was the debugger. It was nice to compare what the machine was seeing to what I
had written out. 



## EXTRA CREDIT:

If the project had opportunities for extra credit that you attempted,  
be sure to call it out so the grader does not overlook it.

---

## SOURCES:

https://www.w3schools.com/java/java_hashset.asp  
https://www.w3schools.com/Java/java_hashmap.asp  
Used AI to format markdown for readme document
All sources used outside of lecture notes, slides, and the textbook need  
to be cited here. If you used websites, used GenAI, asked your dad or your  
boss or your roommate for help then you must cite those resources. I am not  
concerned if you use proper APA or MLA or another format as long as you  
include all relevant information. If it is a person or GenAI that you referenced,  
be sure to include who you talked to (or which AI you accessed), when you  
talked to them, and what help they provided (e.g. Student, Awesome. Private  
communication, 21 January 2026. Discussed how polymorphism allows the return  
types of methods implemented in a class to be different from the class  
specified in the interface as long as the <type in implementation> “is-a” <type in  
interface>.)

---

All content in a README file is expected to be written in clear English with  
proper grammar, spelling, and punctuation. If you are not a strong writer,  
be sure to get someone else to help you with proofreading. Consider all project  
documentation to be professional writing for your boss and/or potential customers.
