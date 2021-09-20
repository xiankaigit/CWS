export default {
    namespaced: true,
    actions: {
        setValue(context, param) {
            context.commit("setValue", param)
        }
    },
    mutations: {
        setValue(state, param) {
            for (var key in param)
                state[key] = param[key]
        }
    },
    state: {
        tabName: "空白页",
    },
    getters: {
        getTabName(state) {
            return state.tabName
        }
    }

}