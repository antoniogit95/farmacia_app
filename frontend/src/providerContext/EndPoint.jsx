const canbiar = true //true servidor, false local

const LOCAL = "http://localhost:8080";
//const SERVER = "http://192.168.158.54:8080" 
const SERVER = "http://10.168.124.54:8080"
const endPoint = canbiar? SERVER : LOCAL; 

export const URL_API_public = `${endPoint}/auth`
export const URL_API_private = `${endPoint}/api/v1`;
