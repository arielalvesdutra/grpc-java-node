// GENERATED CODE -- DO NOT EDIT!

'use strict';
var grpc = require('grpc');
var java_pb = require('./java_pb.js');

function serialize_JavaGreetingRequest(arg) {
  if (!(arg instanceof java_pb.JavaGreetingRequest)) {
    throw new Error('Expected argument of type JavaGreetingRequest');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_JavaGreetingRequest(buffer_arg) {
  return java_pb.JavaGreetingRequest.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_JavaGreetingResponse(arg) {
  if (!(arg instanceof java_pb.JavaGreetingResponse)) {
    throw new Error('Expected argument of type JavaGreetingResponse');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_JavaGreetingResponse(buffer_arg) {
  return java_pb.JavaGreetingResponse.deserializeBinary(new Uint8Array(buffer_arg));
}


var JavaServiceService = exports.JavaServiceService = {
  greeting: {
    path: '/JavaService/greeting',
    requestStream: false,
    responseStream: false,
    requestType: java_pb.JavaGreetingRequest,
    responseType: java_pb.JavaGreetingResponse,
    requestSerialize: serialize_JavaGreetingRequest,
    requestDeserialize: deserialize_JavaGreetingRequest,
    responseSerialize: serialize_JavaGreetingResponse,
    responseDeserialize: deserialize_JavaGreetingResponse,
  },
};

exports.JavaServiceClient = grpc.makeGenericClientConstructor(JavaServiceService);
