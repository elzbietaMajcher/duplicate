# findDuplicateFiles

user can:
- given: path of a folder and matching strategy
the program will search if any file inside given folder has match.

3 matching strategy:
1. same name without extension - return map of duplicated files for which the same name file is find more than one time,
2. same extension - return map of duplicated files for which the same extension file is find more than one time,
3. same size - return map of duplicated files for which the same size file is find more than one time,

Every result will keep all the details 

Example:
1. c:/documents/
2. search strategy: same name
3. output: 
a) picture[picture.jpg, picture.gif]; b) document [document.doc, document.txt, document.xls];

Example:
1. c:/
2. search strategy: same extension
3. output: 
1) doc[picture.doc, something.doc]
