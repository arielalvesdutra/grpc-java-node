import axios, { AxiosResponse } from 'axios'

axios.defaults.timeout = 10000

const baseURL = process.env.JAVA_WEBSERVICE_URL
    ? process.env.JAVA_WEBSERVICE_URL
    : 'http://localhost:3001'

const instance = axios.create({baseURL})

interface HomeResponse {
  data: {
    message: string
    date: Date
  }
}

class JavaWebservice {

  async callHome(): Promise<AxiosResponse<HomeResponse>> {
    return await instance.get<HomeResponse>('/')
  }
}

export default JavaWebservice
