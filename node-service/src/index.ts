import express from 'express'
import JavaWebservice from './httpclient/java-webservice'

import * as grpc from '@grpc/grpc-js';
import * as protoLoader from '@grpc/proto-loader';

const port = 3000
const app = express()
const javaWebservice: JavaWebservice = new JavaWebservice()

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


app.listen(port, () => {
    console.log('hi there! hello')
    console.log(`listening at port ${port}`)
})
