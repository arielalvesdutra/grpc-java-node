const { NodeServiceService } = require("../../grpc/node_grpc_pb")
const NodeGrpcStubs = require("../../grpc/node_pb")

const greeting = ({ request } : any, responseCallback: any) => {
    const message = request.getMessage()
    console.log(`nodeService.greeting()`)
    console.log(`messsage received from a gRPC client: '${message}'`)

    const nodeGreetingResponse = new NodeGrpcStubs.NodeGreetingResponse()
        .setMessage(`message received on the node gRPC server: '${message}'`)

    responseCallback(null, nodeGreetingResponse)
}

module.exports = {
    definition: NodeServiceService,
    implementations: { greeting }
} 
