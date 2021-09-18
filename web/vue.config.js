module.exports = {
    devServer: {
        proxy: {
            '^/nlp/': {
                target: 'http://10.19.170.98:8934',
                changeOrigin: true
            },
            '^/chat/': {
                target: 'http://10.19.170.100:9477',
                changeOrigin: true
            }
        }

    }
};