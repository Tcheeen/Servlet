class_path="/home/tchen/Documents/GitHub/Framework/Framework/build/web/WEB-INF/classes"
librairies_path="/home/tchen/Documents/GitHub/Framework/Test-framework/WEB-INF/lib"
test_class_path="/home/tchen/Documents/GitHub/Framework/Test-framework/WEB-INF/classes"

cd $class_path
jar -cf etu2063Files.jar .
mv etu2063Files.jar $librairies_path
cd $test_class_path
ls ../lib
javac -cp "../lib/*" -d . *java