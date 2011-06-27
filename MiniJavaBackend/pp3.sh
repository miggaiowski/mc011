#***** Set the Classpath including the jar files *****#
echo `find $PWD -name *.jar` | sed -e "s/ /:/g" > tmp && export g10srcpath=`cat tmp` && rm tmp
export g10srcpath=`pwd`:$g10srcpath



#***** Prepare to run the stage 1 *****#
mkdir -p $1/g10/out1
cd $1/in1

#***** Run all the test files in stage 1 *****#
echo "Running tests ..."
for i in `ls` ; 
   do 
      java -cp $g10srcpath main/Main $i
      mv minijava.asm $1/g10/out1/`echo $i | awk -F '.java' '{print $1".asm"}'`
   done



#***** Prepare to run the stage 2 *****#
mkdir -p $1/g10/out2
cd $1/in2

#***** Run all the test files in stage 2 *****#
echo "Running tests ..."
for i in `ls` ; 
   do 
      java -cp $g10srcpath main/Main $i
      mv minijava.asm $1/g10/out2/`echo $i | awk -F '.java' '{print $1".asm"}'`
   done