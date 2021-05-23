#!/bin/sh

PROTO_FILES_FOLDER="./src/proto"
GRPC_OUT_FOLDER=src/grpc
GRPC_FILE="node.proto java.proto"

echo "trying to generate Javascript code from '$GRPC_FILE' file(s) to the folder '$GRPC_OUT_FOLDER'..."

echo "using npm 'grpc-tools' library, which generates the 'grpc_tools_node_protoc' executable..."

rm -rf $GRPC_OUT_FOLDER
mkdir -p $GRPC_OUT_FOLDER

grpc_tools_node_protoc \
    --plugin=protoc-gen-grpc=`which grpc_tools_node_protoc_plugin` \
    --proto_path=$PROTO_FILES_FOLDER \
    --js_out=import_style=commonjs,binary:$GRPC_OUT_FOLDER \
    --grpc_out=:$GRPC_OUT_FOLDER $GRPC_FILE 

echo "node code generated from grpc file(s) '$GRPC_FILE'"
