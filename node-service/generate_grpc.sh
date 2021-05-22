#!/bin/sh

GRPC_OUT_FOLDER=src/grpc
GRPC_FILE=node.proto

echo "trying to generate Javascript code from '$GRPC_FILE' file to the folder '$GRPC_OUT_FOLDER'..."

echo "using npm 'grpc-tools' library, which generates the 'grpc_tools_node_protoc' executable..."

grpc_tools_node_protoc \
    --plugin=protoc-gen-grpc=`which grpc_tools_node_protoc_plugin` \
    --proto_path=./ \
    --js_out=import_style=commonjs,binary:$GRPC_OUT_FOLDER \
    --grpc_out=:$GRPC_OUT_FOLDER $GRPC_FILE

echo "node code generated from grpc file '$GRPC_FILE'"
