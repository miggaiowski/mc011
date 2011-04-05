mkdir -p $1/out
for i in `ls ./$1/in/*.java | xargs -n1 basename | awk -F \. '{ print $1 }'` ; do echo "Running test $i.java ..."; java mainpkg/Compiler < ./$1/in/$i.java > ./$1/out/$i.out; done

