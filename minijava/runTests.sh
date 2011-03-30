for i in `awk -F \/ '{ print $NF }' fl.txt`; do java mainpkg/Compiler < testes/large/$i > testes/results/$i; done 

