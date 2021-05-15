# Acho que só roda em Linux e em WSL

mkdir -p build
find src -name "*.java" | xargs javac -d build
cd build
jar cfm ../controle-estacionamento-pago.jar ../META-INF/MANIFEST.MF *
cd .. 
chmod +x controle-estacionamento-pago.jar
