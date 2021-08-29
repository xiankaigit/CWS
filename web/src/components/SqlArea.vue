<template>
    <el-input
            type="textarea"
            :autosize="{ minRows: 4}"
            placeholder="请输入sql语句"
            v-model="sql"
    style="padding-top: 0px;height: 300px">
    </el-input>
</template>

<script>
    export default {
        name:"SqlArea",
        components: {
        },
        data() {
            return {
                sql: '',
                "options:":{

                }
            }
        },
        methods: {
            onChange(value) {
                console.log(value);
            }
        }
    }
</script>

<style scoped>

</style>