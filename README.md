# Project Descritpion

> Java program that [topologically sorts](https://en.wikipedia.org/wiki/Topological_sorting) a set of partially-ordered elements. Program uses Kahn’s algorithm that is also discussed on the wiki page.

# Project Features

  - Reads input from file via the command line. Input files consist of the following (see topoTest.txt): 
    - The input file may have zero or more lines of comments starting with 'c '
    - followed by an integer that represents the number of nodes in the graph 
    - followed by one edge per line. A pair of integers represents a directed edge from the first integer to the second i.e. (1, 2)             represents an edge from 1 to 2. Meaning edge 1 must precede edge 2.
  - Outputs its results to file (see topoOutput.txt). Outputs the entire sorted sequence of nodes in one line. If a topological sort is       not possible, outputs the message that the graph contains a cycle.
