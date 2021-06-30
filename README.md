# Background
This is a coding chanllenge. The calculator is designed to calculate the cost and bundle breakdown based on given brands order and budnles.

Submission format | Format code | Bundles
----------------- | ----------- | -------
Image | IMG | 5 @ $450 10 @ $800
Audio | Flac | 3 @ $427.50 6 @ $810 9 @ $1147.50
Video | VID | 3 @ $570 5 @ $900 9 @ $1530
The following is example input and output. 
### Input:
Each order has a series of lines with each line containing the number of items followed by the submission format code
An example input:
```
10 IMG
15 FLAC
13 VID
```

### Output:
A successfully passing test(s) that demonstrates the following output: (The format of the output is not important)
```
10 IMG $800
  1 x 10 $800
15 FLAC $1957.50
  1 x 9 $1147.50
  1 x 6 $810
13 VID $2370
  2 x 5 $1800
  1 x 3 $570
```

# Install
No installation requirement 

# File structure
    ├── Input                   # the input file for the program
    │   ├── testInput           # txt file for input
    ├── src                     # Source files
    │   ├── budleCalculator     # the main program
    └── README.md

# Usage
directly run the main program in the bundleCalculator file in source directory
