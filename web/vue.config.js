module.exports = {
    devServer: {
        proxy: {
            '^/cws/rest/': {
                target: 'http://10.33.57.32:8888',
                changeOrigin: true
            }
        }
    }
};