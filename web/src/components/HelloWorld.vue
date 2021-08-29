<template>
    <div class="hello">
        <a @click="health">点我检查服务器健康状况</a>
    </div>
</template>

<script>
   // import axios from 'axios'

    export default {
        name: 'HelloWorld',
        methods: {
            health() {
                // console.log("触发health")
                // axios.get("http://localhost:8080/cws/system/health").then(
                //     response => {
                //         console.log('请求成功了')
                //         //请求成功后更新List的数据
                //     },
                //     error => {
                //         console.info(response)
                //         console.log('请求失败了')
                //     }
                // )
            }
        }
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
