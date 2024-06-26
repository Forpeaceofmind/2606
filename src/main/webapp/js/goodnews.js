document.addEventListener('DOMContentLoaded', function() {
    fetch('https://www.goodnewsnetwork.org/category/news/')
        .then(response => response.text())
        .then(data => {
            const parser = new DOMParser();
            const htmlDocument = parser.parseFromString(data, 'text/html');
            const articles = htmlDocument.querySelectorAll('.td_module_1');
            const newsContainer = document.getElementById('news-container');

            articles.forEach(article => {
                const title = article.querySelector('.entry-title').textContent;
                const brief = article.querySelector('.td-excerpt').textContent;
                const link = article.querySelector('.entry-title a').href;

                const articleDiv = document.createElement('div');
                articleDiv.classList.add('article');
                articleDiv.innerHTML = `
                    <h2>${title}</h2>
                    <p>${brief}</p>
                    <a href="${link}" target="_blank">Read More</a>
                `;

                newsContainer.appendChild(articleDiv);
            });
        })
        .catch(error => console.error('Error fetching data:', error));
});
function validateForm() {
  var title = document.getElementById('title').value;
  var brief = document.getElementById('brief').value;
  var date = document.getElementById('date').value;
  var id = document.getElementById('id').value;
  var category = document.getElementById('category').value;
  
  if (!title || !brief || !date || !id || !category) {
    alert('Please fill in all fields.');
    return false;
  }
  
  return true;
}
