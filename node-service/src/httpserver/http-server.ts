import express from 'express'
import JavaWebservice from '../httpclient/java-webservice'


const DEFAULT_SERVER_PORT = 3000

const javaWebservice: JavaWebservice = new JavaWebservice()
const app = express()

app.get('/', (req, resp) => {

    console.log(`message received ${req.body? req.body : ''} at ${new Date()}`)    
    return resp.send({
        data: {
            message: 'hi! this message was created on a node.js server',
            date: new Date()
        }
    })
})

app.get('/java_webservice/', async (_, resp) => {
    const result = await javaWebservice.callHome()
    console.log(`java webservice response: ${result.data}`)

    return resp.send({
        data: result.data.data,
        node_marker: 'node mark!'
    })
})


const start = (serverPort: number = DEFAULT_SERVER_PORT) => {
    app.listen(serverPort, () => {
        console.log(`listening HTTP at port ${serverPort}`)
    })
}

export default { start }
