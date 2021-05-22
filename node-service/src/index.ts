import grpcServer from './grpcserver/grpc-server'
import httpserver from './httpserver/http-server'

console.log('hi there! hello')

httpserver.start()
grpcServer.start()
