import express from 'express'

const port = 3000
const app = express()

app.get('/', (req, resp) => {

    console.log(`message received ${req.body? req.body : ''} at ${new Date()}`)    
    resp.send({ 
        message: 'hello!',
        date: new Date()
    })
})


app.listen(port, () => {
    console.log('hi there! hello')
    console.log(`listening at port ${port}`)
})
