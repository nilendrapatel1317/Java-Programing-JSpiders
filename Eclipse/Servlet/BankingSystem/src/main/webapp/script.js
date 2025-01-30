       // Remove toast automatically after 2 seconds
       setTimeout(() => {
           const toast = document.getElementById('toastMessage');
           if (toast) {
               toast.remove();
           }
       }, 5000);

       // Remove toast when close button is clicked
       document.getElementById('closeToast').addEventListener('click', () => {
           const toast = document.getElementById('toastMessage');
           if (toast) {
               toast.remove();
           }
       });

	   
	   //<div id="toastMessage"
	   //	class="bg-success text-white p-3 w-25 position-absolute bottom-0 end-0 mb-2 me-2">
	   //		<div class="d-flex">
	   //			<div class="toast-body">Hello, world! This is a toast message.</div>
	   //			<button type="button" id="closeToast" class="btn-close me-2 m-auto"></button>
	   //		</div>
	   //</div>