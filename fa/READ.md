# ****************
# Project 1
# Class CS361
# Date 02/18/2026
# Calvin Arnold, Audrey Fitchett
# ****************

## OVERVIEW:

Concisely explain what the program does. If this exceeds a couple  
of sentences, you're going too far. The details go in other  
sections.

---

## INCLUDED FILES:

List the files required for the project with a brief  
explanation of why each is included.

e.g.

- Class1.java - source file  
- Class2.java - source file  
- README - this file  

---

## COMPILING AND RUNNING:

Give the command for compiling the program, the command  
for running the program, and any usage instructions the  
user needs.

These are command-line instructions for a system like onyx.  
They have nothing to do with Eclipse or any other IDE. They  
must be specific - assume the user has Java installed, but  
has no idea how to compile or run a Java program from the  
command-line.

e.g.

From the directory containing all source files, compile the  
driver class (and all dependencies) with the command:

```
$ javac Class1.java
```

Run the compiled class file with the command:

```
$ java Class1
```

Console output will give the results after the program finishes.

---

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

How did you test your program to be sure it works and meets all of the  
requirements? What was the testing strategy? What kinds of tests were  
run?

Can your program handle bad input? Is your program idiot-proof? How do  
you know? What are the known issues / bugs remaining in your program?

---

## DISCUSSION:

-Calvin: The most challenging part of this assignment was visualizing the interaction between the HashMap and HashSet data structures, particularly when implementing the transition function. The nested delta map (mapping a state to another map of symbol-to-state transitions) was difficult to conceptualize mentally. I frequently found myself losing track of which keys mapped to which values during debugging.

I also reviewed these W3schools articles on the java hashmap/set packages.

https://www.w3schools.com/java/java_hashset.asp  
https://www.w3schools.com/Java/java_hashmap.asp  

What helped significantly was writing out a visual representation of the structure on paper.



## EXTRA CREDIT:

If the project had opportunities for extra credit that you attempted,  
be sure to call it out so the grader does not overlook it.

---

## SOURCES:

https://www.w3schools.com/java/java_hashset.asp  
https://www.w3schools.com/Java/java_hashmap.asp  

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
