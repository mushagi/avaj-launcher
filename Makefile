SRC_FILE=sources.txt
SRC_DIR =src
BIN_DIR=bin

all:
	find . -type f -name "*.java" > $(SRC_FILE)
	mkdir -p $(BIN_DIR)
	javac -d $(BIN_DIR) -sourcepath @$(SRC_FILE)

clean:
	rm -rf $(BIN_DIR)
