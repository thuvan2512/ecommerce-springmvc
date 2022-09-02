
function loadChartTopSellerInAdmin(labels, data) {
    const ctx = document.getElementById('chart-top-seller-admin').getContext('2d');
    const myChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: labels,
            datasets: [{
                    label: 'Top Seller',
                    data: data,
                    backgroundColor: [
                        '#74b9ff',
                        '#d63031',
                        '#1abc9c',
                        '#fdcb6e',
                        '#0984e3',
                        '#2d3436',
                        '#00b894',
                        '#e17055',
                        '#d63031',
                        '#8e44ad',
                        '#2ecc71',
                        '#bdc3c7',
                    ],
                    borderWidth: 1
                }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });

}
function loadChartStatsCategoryInAdmin(labels, data) {
    const ctx = document.getElementById('chart-stats-by-category-admin').getContext('2d');
    const myChart = new Chart(ctx, {
        type: 'pie',
        data: {
            labels: labels,
            datasets: [{
                    label: 'Statistics by product category',
                    data: data,
                    backgroundColor: [
                        '#d63031',
                        '#1a7c9c',
                        '#fdcb6e',
                        '#e17055',
                        '#2d3436',
                        '#0984e3',
                        '#00b894',
                        '#7459ff',
                        '#d63031',
                        '#8e44ad',
                        '#2ecc71',
                        '#bdc3c7',
                    ],
                    borderWidth: 1
                }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });

}

function loadChartTopSellerInAdminStats(labels, data) {
    const ctx = document.getElementById('chart-top-seller-admin-stats').getContext('2d');
    const myChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: labels,
            datasets: [{
                    label: 'Top Seller',
                    data: data,
                    backgroundColor: [
                        '#74b9ff',
                        '#d63031',
                        '#1abc9c',
                        '#fdcb6e',
                        '#0984e3',
                        '#2d3436',
                        '#00b894',
                        '#e17055',
                        '#d63031',
                        '#8e44ad',
                        '#2ecc71',
                        '#bdc3c7',
                    ],
                    borderWidth: 1
                }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });

}
function loadChartStatsCategoryInAdminStats(labels, data) {
    const ctx = document.getElementById('chart-stats-by-category-admin-stats').getContext('2d');
    const myChart = new Chart(ctx, {
        type: 'pie',
        data: {
            labels: labels,
            datasets: [{
                    label: 'Statistics by product category',
                    data: data,
                    backgroundColor: [
                        '#d63031',
                        '#1a7c9c',
                        '#fdcb6e',
                        '#e17055',
                        '#2d3436',
                        '#0984e3',
                        '#00b894',
                        '#7459ff',
                        '#d63031',
                        '#8e44ad',
                        '#2ecc71',
                        '#bdc3c7',
                    ],
                    borderWidth: 1
                }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });

}

function loadChartStatsSalesFrequency(labels, data) {
    const ctx = document.getElementById('chart-stats-by-sale-frequency').getContext('2d');
    const myChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: labels,
            datasets: [{
                    label: 'Statistics by product category',
                    data: data,
                    backgroundColor: [
                        '#d63031',
                        '#1a7c9c',
                        '#fdcb6e',
                        '#e17055',
                        '#2d3436',
                        '#0984e3',
                        '#00b894',
                        '#7459ff',
                        '#d63031',
                        '#8e44ad',
                        '#2ecc71',
                        '#bdc3c7',
                    ],
                    borderWidth: 1
                }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });

}

