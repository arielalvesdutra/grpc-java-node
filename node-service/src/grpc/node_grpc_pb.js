// GENERATED CODE -- DO NOT EDIT!

'use strict';
var grpc = require('grpc');
var node_pb = require('./node_pb.js');

function serialize_NodeGreetingRequest(arg) {
  if (!(arg instanceof node_pb.NodeGreetingRequest)) {
    throw new Error('Expected argument of type NodeGreetingRequest');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_NodeGreetingRequest(buffer_arg) {
  return node_pb.NodeGreetingRequest.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_NodeGreetingResponse(arg) {
  if (!(arg instanceof node_pb.NodeGreetingResponse)) {
    throw new Error('Expected argument of type NodeGreetingResponse');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_NodeGreetingResponse(buffer_arg) {
  return node_pb.NodeGreetingResponse.deserializeBinary(new Uint8Array(buffer_arg));
}


var NodeServiceService = exports.NodeServiceService = {
  greeting: {
    path: '/NodeService/greeting',
    requestStream: false,
    responseStream: false,
    requestType: node_pb.NodeGreetingRequest,
    responseType: node_pb.NodeGreetingResponse,
    requestSerialize: serialize_NodeGreetingRequest,
    requestDeserialize: deserialize_NodeGreetingRequest,
    responseSerialize: serialize_NodeGreetingResponse,
    responseDeserialize: deserialize_NodeGreetingResponse,
  },
};

exports.NodeServiceClient = grpc.makeGenericClientConstructor(NodeServiceService);
