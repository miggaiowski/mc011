for i in `ls ./testes/large/*.java | xargs -n1 basename`; do echo "Running $i..."; java mainpkg/Compiler < testes/large/$i > testes/results/$i; done



