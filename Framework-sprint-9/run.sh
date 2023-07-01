cd Framework/build/web/WEB-INF/classes
jar -cf etu2063Files.jar .
mv etu2063Files.jar ../../../../../Test-framework/WEB-INF/lib
cd ../../../../../Test-framework/WEB-INF/classes
javac -cp ../lib/* -d . *java