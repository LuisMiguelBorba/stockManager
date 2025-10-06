#!/bin/bash
PROJETO_DIR="/home/miguel/IdeaProjects/semNome/src"
MAIN_CLASS="Main"

cd "$PROJETO_DIR" || exit

echo "🔨 Compilando arquivos Java..."
javac *.java
if [ $? -ne 0 ]; then
    echo "❌ Erro na compilação!"
    exit 1
fi

echo "🚀 Executando programa..."
java $MAIN_CLASS

