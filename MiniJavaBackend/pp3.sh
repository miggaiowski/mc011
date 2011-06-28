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

      echo "Running STAGE $2 tests ..."
      for i in `ls *.java` ; 
         do 
            FILE_FULL_NAME=$1/g10/out$2/`echo $i | awk -F '.java' '{print $1}'`
            FILE_NAME_ONLY=`echo $FILE_FULL_NAME | awk -F "out$2/" '{print $2}'`
            /usr/bin/time --quiet -f "$FILE_NAME_ONLY %U" -a -o $1/g10/out$2/g10.time java -cp $g10classpath main/Main $i
            mv minijava.asm $FILE_FULL_NAME.asm
            nasm -felf $FILE_FULL_NAME.asm
            gcc $RUNTIME_OBJ $FILE_FULL_NAME.o -o $FILE_FULL_NAME
            rm $FILE_FULL_NAME.o
         done
      #*************************#
   else
      #***** Show how to use de script *****#
      echo "Usage: ./pp3.sh <pasta> <#etapa>"
      echo "<pasta>  : Pendrive contendo os testes"
      echo "<#etapa> : Numero da etapa a ser realizada"
fi
