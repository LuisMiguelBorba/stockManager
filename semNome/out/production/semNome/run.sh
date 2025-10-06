#!/bin/bash
MAIN_CLASS="Main"

echo "🔨 Compilando arquivos Java..."
javac *.java
if [ $? -ne 0 ]; then
    echo "❌ Erro na compilação!"
    exit 1
fi

echo "🚀 Executando programa..."
java $MAIN_CLASS

