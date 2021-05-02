import express from 'express'
import JavaWebservice from './httpclient/java-webservice'

const port = 3000
const app = express()

const javaService: JavaWebservice = new JavaWebservice()

app.get('/', (req, resp) => {

    console.log(`message received ${req.body? req.body : ''} at ${new Date()}`)    
    return resp.send({
        data: {
            message: 'hi! this message was created on a node.js server',
            date: new Date()
        }
    })
})

app.get('/java_webservice/', async (req, resp) => {
    const result = await javaService.callHome()
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
