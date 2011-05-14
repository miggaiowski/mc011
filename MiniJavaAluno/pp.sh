#***** Prepare the ambient for running the script *****#
 export g10srcpath=`pwd`
 mkdir -p $1/g10
 mkdir -p $1/gall
 rm -f $1/gall/g10.out
 cd $1/in

#***** Run all the test files *****#
 echo "Running tests ..."
 for i in `ls` ; 
    do 
       java -cp $g10srcpath main/Main $i 2> ../g10/$i.out;
    done

#***** Merge all the output into one file *****#
 cd $g10srcpath
 echo "G10---------------------------------------------------------------------" >> $1/gall/g10.out
 for i in `ls $1/g10` ;
    do
       cat $1/g10/$i >> $1/gall/g10.out
    done
    
    
