import { Injectable, Inject, RendererFactory2, Renderer2 } from '@angular/core';
import { DOCUMENT } from '@angular/common';

@Injectable({
  providedIn: 'root'
})
export class DomBodyService {

    private renderer: Renderer2;

    constructor(@Inject(DOCUMENT) private document: Document, rendererFactory: RendererFactory2) {
        this.renderer = rendererFactory.createRenderer(null, null);
    }

    addClassToBody(className: string) {
        this.renderer.addClass(this.document.body, className);
    }

}
