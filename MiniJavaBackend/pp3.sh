#***** Check the input format ***#
if [ $# == 2 ]
   then
      #***** Set the Classpath including the jar files *****#
      echo `find $PWD -name *.jar` | sed -e "s/ /:/g" > tmp && export g10classpath=`cat tmp` && rm tmp
      export g10classpath=`pwd`:$g10classpath

      #***** Create the runtime.o *****#
      gcc -c $PWD/runtime/runtime.c
      RUNTIME_OBJ=$PWD/runtime.o


      #***** Generic mode *****#
      mkdir -p $1/g10/out$2
      cd $1/in$2

      echo "Running STAGE $2 tests ...";read
      for i in `ls *.java` ; 
         do 
            java -cp $g10classpath main/Main $i
            FILE_NAME=$1/g10/out$2/`echo $i | awk -F '.java' '{print $1}'`
            mv minijava.asm $FILE_NAME.asm
            nasm -felf $FILE_NAME.asm
            gcc $RUNTIME_OBJ $FILE_NAME.o -o $FILE_NAME
            rm $FILE_NAME.o
         done
      #*************************#
   else
      #***** Show how to use de script *****#
      echo "Usage: ./pp3.sh <pasta> <#etapa>"
      echo "<pasta>  : Pendrive contendo os testes"
      echo "<#etapa> : Numero da etapa a ser realizada"
fi



##***** Set the Classpath including the jar files *****#
#echo `find $PWD -name *.jar` | sed -e "s/ /:/g" > tmp && export g10classpath=`cat tmp` && rm tmp
#export g10classpath=`pwd`:$g10classpath
#
#***** Create the runtime.o *****#
#gcc -c $PWD/runtime/runtime.c
#RUNTIME_OBJ=$PWD/runtime.o
#
#
#***** Prepare to run the stage 1 *****#
#mkdir -p $1/g10/out1
#cd $1/in1
#
#***** Run all the test files in stage 1 *****#
#echo "Running STAGE 1 tests ..."
#for i in `ls *.java` ; 
#   do 
#      java -cp $g10classpath main/Main $i
#      FILE_NAME=$1/g10/out1/`echo $i | awk -F '.java' '{print $1}'`
#      mv minijava.asm $FILE_NAME.asm
#      nasm -felf $FILE_NAME.asm
#      gcc $RUNTIME_OBJ $FILE_NAME.o -o $FILE_NAME
#      rm $FILE_NAME.o
#   done
#
#
#
##***** Prepare to run the stage 2 *****#
#mkdir -p $1/g10/out2
#cd $1/in2
#
##***** Run all the test files in stage 2 *****#
#echo "Running STAGE 2 tests ..."
#for i in `ls *.java` ; 
#   do 
#      java -cp $g10classpath main/Main $i
#      FILE_NAME=$1/g10/out2/`echo $i | awk -F '.java' '{print $1}'`
#      mv minijava.asm $FILE_NAME.asm
#      nasm -felf $FILE_NAME.asm
#      gcc $RUNTIME_OBJ $FILE_NAME.o -o $FILE_NAME
#      rm $FILE_NAME.o
#   done