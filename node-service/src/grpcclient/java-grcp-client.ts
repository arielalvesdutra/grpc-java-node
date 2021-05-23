import { response } from "express"

const grpc = require('grpc')
const services = require('../grpc/java_grpc_pb')
const messages = require('../grpc/java_pb')

const GRPC_SERVER_TARGET = 'localhost:50052'


export default class JavaGrpcClient {

    grpcClient: any

    constructor(serverTarget: string = GRPC_SERVER_TARGET) {
        const insecureCredentials = grpc.credentials.createInsecure()
        this.grpcClient = new services.JavaServiceClient(serverTarget, insecureCredentials)
    }

    async callJavaGrpcGreeting() {
        console.log('javaService.greeting()')
        const requestDTO = new messages.JavaGreetingRequest()
            .setMessage('message created on a node grpc client')

        return new Promise((resolve, reject) => {
            this.grpcClient.greeting(requestDTO, (error: any, response: any) => {
                if (error) 
                    reject(error)
                resolve(response)
             })
        })
    }
}
