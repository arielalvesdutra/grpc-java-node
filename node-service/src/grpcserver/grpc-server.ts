

const grpc  = require('@grpc/grpc-js')
const NodeServiceService = require('./service/grpc-service')

const DEFAULT_GRPC_SERVER_PORT = '0.0.0.0:50051'

const start = (serverPort: string = DEFAULT_GRPC_SERVER_PORT) => {
    const insecureCredentials = grpc.ServerCredentials.createInsecure()
    const server = new grpc.Server()
    server.addService(NodeServiceService.definition, NodeServiceService.implementations)
    server.bindAsync(serverPort, insecureCredentials, () => {
        console.log(`listening gRPC at port ${serverPort}`)
        server.start()
    })
}

export default { start } 
