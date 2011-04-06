#COMECA O SCRIPT#
sablecc minijava.grammar 
mv PrettyPrint.java analysis/
echo "--- Compiling Started."
for i in `find ./analysis/ -name *.java`; do echo $i; javac $i; done
for i in `find ./lexer/ -name *.java`; do echo $i; javac $i; done
for i in `find ./parser/ -name *.java`; do echo $i; javac $i; done
for i in `find ./node/ -name *.java`; do echo $i; javac $i; done
for i in `find ./mainpkg/ -name *.java`; do echo $i; javac $i; done
echo "--- Compiling finished."
echo "--- Type 'java mainpkg/Compiler' to run the application"
echo "--- Type './pp.sh <path/to/directory>' to execute all tests" 
#FIM DO SCRIPT#
