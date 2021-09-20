<template>
    <el-container>

        <el-container>
            <el-header style="text-align: left">欢迎使用超级计算工作站（CWS）</el-header>
            <el-container>
                <el-aside id="nav-aside" width="200px" style="background-color: rgb(84,92,100); ">
                    <Navigation></Navigation>
                </el-aside>
                <el-container>
                    <el-header
                            style="text-align: left;vertical-align:middle;line-height: 30px;background-color: #E9EEF3;height: 50px;padding: 15px">
                        <el-page-header @back="goBack" :content="tabName">
                        </el-page-header>
                    </el-header>
                    <el-main>
                        <ContextBody></ContextBody>
                    </el-main>
                </el-container>

            </el-container>
        </el-container>
    </el-container>
</template>

<script>
import Navigation from "./Navigation";
import SqlArea from "../task/SqlArea";
import ContextBody from "./ContextBody";
import {mapState} from "vuex";

export default {
    name: "Layout",
    components: {Navigation, SqlArea, ContextBody},
    data() {
        const item = {
            date: '2016-05-02',
            name: '王小虎',
            address: '上海市普陀区金沙江路 1518 弄'
        };
        return {
            tableData: Array(20).fill(item)
        }
    },
    computed: {
        ...mapState('base', ['tabName'])
    },
    methods: {
        goBack() {
            this.$router.back()
        }
    }
};

</script>

<style scoped>
.el-header, .el-footer {
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 60px;
}

.el-aside {
    background-color: #D3DCE6;
    color: #333;
    line-height: 200px;
}

.el-main {
    /*background-color: #E9EEF3;*/
    /*color: #333;*/
}

body > .el-container {
    margin-bottom: 40px;
    height: 100vh;
}

.el-container:nth-child(5) .el-aside,
.el-container:nth-child(6) .el-aside {
    line-height: 260px;
}

.el-container:nth-child(7) .el-aside {
    line-height: 320px;
}

</style>
