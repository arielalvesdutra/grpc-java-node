import axios, { AxiosResponse } from 'axios'

axios.defaults.timeout = 10000

const backendUrl = process.env.REACT_APP_BACKEND_URL
    ? process.env.REACT_APP_BACKEND_URL
    : 'http://localhost:3001'

const instance = axios.create({
  baseURL: backendUrl
})


interface HomeResponse {
  data: {
    message: string
    date: Date
  }
}

class JavaWebservice {

  async callHome(): Promise<AxiosResponse<HomeResponse>> {
    const response = await instance.get<HomeResponse>('/')
    return response
  }
}

export default JavaWebservice
