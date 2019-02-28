# findDuplicateFiles

user can:
- given: path of a folder, matching strategy, path to save output.

The program will search if any file inside given folder has a match + saving output to .txt

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
b) save to newFile.txt

Example:
1. c:/
2. search strategy: same extension
3. output: 
a) doc[picture.doc, something.doc]
b) save to newOtherFile.txt