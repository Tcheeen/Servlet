chemin_webapps="/home/tchen/Documents/apache-tomcat-9.0.76/webapps"
chemin_bin="/home/tchen/Documents/apache-tomcat-9.0.76/bin"
framework_dir="/home/tchen/Documents/GitHub/Framework"
package_name="objet"

echo "Création du répertoire temporaire"
mkdir temp
cd temp
mkdir WEB-INF
cd WEB-INF
mkdir classes
cd classes 
mkdir $package_name
cd ..
mkdir lib
cd ../..    

echo "Copie des fichiers jsp"

cp Test-framework/*.jsp temp/
echo "Copie des fichiers de configuraiton"
cp Test-framework/WEB-INF/web.xml temp/WEB-INF/
echo "Copie de la librairie"
cp Test-framework/WEB-INF/lib/* temp/WEB-INF/lib/
echo "Copie des classes"

cp Test-framework/WEB-INF/classes/$package_name/*.class temp/WEB-INF/classes/$package_name/
rm test/WEB-INF/classes/*.java

cd temp
jar -cvf etu2063Framework.war .
echo "Suppression du répertoire temporaire"
mv etu2063Framework.war $chemin_webapps
cd ..

rm -r temp
cd $chemin_bin

echo "Tomcat RELOADING ...................."
sleep 2
./shutdown.sh
./startup.sh

cd $framework_dir