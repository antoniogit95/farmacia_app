import privateApi from "../api/privateApi";


export const personalService = {
    
    getAll: async () => {
        const { data } = await privateApi.get("/user/list");
        return data;
    },

    create: async (user) =>{
        const { data } = await privateApi.post("/user/create", user);
        return data;
    },

    update: async ({ id, user }) => {
        const { data } = await privateApi.put(`/user/update/${id}`, user);
        return data;
    },

    existCi: async (ci) => {
        const { data } = await privateApi.get(
            `/person/existci?ci=${ci}`
        );
        return data;
    },

    existUsername: async (username) => {

        const { data } = await privateApi.get(
            `/user/existuser?username=${encodeURIComponent(username)}`
        );

        return data;
    },

}