import VueRouter from 'vue-router'
import SqlArea from "@/components/SqlArea";

export default new VueRouter({
    routes: [
        {
            name: 'sql',
            path: '/sql',
            component: SqlArea
        }
    ]
})