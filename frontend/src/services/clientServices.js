import privateApi from "../api/privateApi";

export const clientService = {

    getAll: async () => {
        const { data } = await privateApi.get("/client/list");
        return data;
    },

    create: async (client) => {
        const { data } = await privateApi.post("/client/add", client);
        return data;
    },

    update: async ({ id, client }) => {
        const { data } = await privateApi.put(`/client/update/${id}`,client);
        return data;
    },

    delete: async (id) => {
        const { data } = await privateApi.delete(
            `/client/delete/${id}`
        );
        return data;
    },

    existCi: async (ci) => {
        const { data } = await privateApi.get(
            `/person/existci?ci=${ci}`
        );
        return data;
    }
};